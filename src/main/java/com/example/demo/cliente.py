import requests  
#nop he usado flask sino que he usado de interfaz grafica el terminal 

BASE_URL = "http://localhost:8080" 
PRODUCTS_ENDPOINT = f"{BASE_URL}/productos"  #para operaciones CRUD
STATS_ENDPOINT = f"{BASE_URL}/productos/estadisticas" # para estadisticas



def listar_productos():
    response = requests.get(PRODUCTS_ENDPOINT)
    if response.status_code == 200:#el codigo 200 signifca que la peticion fue recibida y correcta 
        productos = response.json()
        print("\nLista de productos:")
        for producto in productos:
            print(f"ID: {producto['id']}, Nombre: {producto['nombre']}, Precio: {producto['precio']}, Cantidad: {producto['cantidad']}")
    else:
        print("Error al obtener la lista de productos:", response.text)

def agregar_producto():
    nombre = input("Introduce el nombre del producto: ")
    precio = float(input("Introduce el precio del producto: "))
    cantidad = int(input("Introduce la cantidad del producto: "))
    
    producto = {
        "nombre": nombre,
        "precio": precio,
        "cantidad": cantidad
    }
    response = requests.post(PRODUCTS_ENDPOINT, json=producto)
    if response.status_code == 200:
        print("Producto agregado exitosamente:", response.json())
    else:
        print("Error al agregar el producto:", response.text)

def modificar_producto():
    id_producto = input("Introduce el ID del producto que deseas modificar: ")
    nombre = input("Introduce el nuevo nombre del producto: ")
    precio = float(input("Introduce el nuevo precio del producto: "))
    cantidad = int(input("Introduce la nueva cantidad del producto: "))
    
    producto = {
        "nombre": nombre,
        "precio": precio,
        "cantidad": cantidad
    }
    response = requests.put(f"{PRODUCTS_ENDPOINT}/{id_producto}", json=producto)
    if response.status_code == 200:
        print("Producto modificado exitosamente:", response.json())
    else:
        print("Error al modificar el producto:", response.text)

def eliminar_producto():
    id_producto = input("Introduce el ID del producto que deseas eliminar: ")
    response = requests.delete(f"{PRODUCTS_ENDPOINT}/{id_producto}")

    if response.status_code == 200:
        if response.text.lower() == "true":
            print("Producto eliminado exitosamente.")
        else:
            print(f"Error: No se encontró el producto con ID {id_producto}.")
    else:
        print(f"Error al eliminar el producto: {response.status_code} - {response.text}")


def consultar_estadisticas():
    response = requests.get(STATS_ENDPOINT)
    if response.status_code == 200:
        estadisticas = response.json()
        if estadisticas:
            print("\nEstadísticas de las peticiones:")
            for key, value in estadisticas.items():
                print(f"{key}: {value} peticiones")
        else:
            print("No hay estadísticas disponibles.")
    else:
        print("Error al consultar las estadísticas:", response.text)


def menu():
    while True:
        print("\nMenú de opciones:")
        print("1. Listar productos")
        print("2. Agregar producto")
        print("3. Modificar producto")
        print("4. Eliminar producto")
        print("5. Consultar estadísticas")
        print("6. Salir")
        
        opcion = input("Selecciona una opción: ")
        
        if opcion == "1":
            listar_productos()
        elif opcion == "2":
            agregar_producto()
        elif opcion == "3":
            modificar_producto()
        elif opcion == "4":
            eliminar_producto()
        elif opcion == "5":
            consultar_estadisticas()
        elif opcion == "6":
            print("Saliendo del cliente...")
            break
        else:
            print("Opción no válida. Inténtalo de nuevo.")

if __name__ == "__main__":
    menu()

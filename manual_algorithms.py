def lineal_search(arr:list[int], element:int)->int:
    # Inicializar un índice para recorrer la lista
    i = 0;

    # Iterar sobre la lista mientras el índice sea menor que la longitud de la lista
    # y el elemento en el índice actual no sea igual al elemento buscado
    while (i < len(arr) and arr[i]!= element):
        i += 1

    # Si el índice es menor que la longitud de la lista, significa que se encontró el elemento
    if i < len(arr): return i
    else: return -1

def binary_search(arr:list[int], element:int, left:int, right:int)->int:
    while left <= right:
        # Calcular el índice medio del arreglo
        mid = (left + right) // 2
        
        # Verificar si el objetivo está en el medio
        if arr[mid] == element:
            return mid
        
        # Si el objetivo es menor que el valor medio, buscar en la mitad izquierda del arreglo
        if arr[mid] > element:
            right = mid - 1
        # Si el objetivo es mayor que el valor medio, buscar en la mitad derecha del arreglo
        else:
            left = mid + 1
            
    # Si el objetivo no está en el arreglo, retornar -1
    return -1

def insertion_sort(arr: list[int]) -> list[int]:
    for j in range(1, len(arr)):
        key = arr[j]
        i = j - 1

        # Desplazamos hacia la derecha los elementos de la lista
        # que sean mayores que 'key' para hacer espacio para 'key'
        while i >= 0 and arr[i] > key:
            arr[i + 1] = arr[i]
            i = i - 1

        # Insertamos 'key' en su posición correcta
        arr[i + 1] = key

array = [34,2,5,6,8,7, 6]

def selection_sort(arr: list[int]) -> list[int]:
    for i in range(len(arr)):
        # Inicialmente, asumimos que el elemento actual es el mínimo
        min_index = i

        # Recorremos el resto de la lista para encontrar el elemento más pequeño
        for j in range(i + 1, len(arr)):
            # Si encontramos un elemento más pequeño, actualizamos min_index
            if arr[min_index] > arr[j]:
                min_index = j

        # Intercambiamos el elemento actual con el elemento más pequeño encontrado
        arr[i], arr[min_index] = arr[min_index], arr[i]

def bubble_sort(arr: list[int]) -> list[int]:
    for i in range(len(arr)):
        # Recorremos la lista desde el principio hasta el último elemento no ordenado
        for j in range(len(arr) - 1 - i):
            # Si el elemento actual es mayor que el siguiente, los intercambiamos
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]

def merge(left_arr:list[int], right_arr:list[int])->list[int]:
    result = []

    while len(left_arr) > 0 and len(right_arr) > 0:
        if left_arr[0] > right_arr[0]:
            result.append(right_arr[0])
            right_arr.pop(0)
        else:
            result.append(left_arr[0])
            left_arr.pop(0)
    
    while len(left_arr) > 0:
        result.append(left_arr[0])
        left_arr.pop(0)

    while len(right_arr) > 0:
        result.append(right_arr[0])
        right_arr.pop(0)

    return result

def merge_sort(arr: list[int])->list[int]:
    if len(arr) == 1: return arr
    
    middle = len(arr) // 2
    left_arr = arr[:middle]
    right_arr = arr[middle:]

    sorted_left_arr = merge_sort(left_arr)
    sorted_right_arr = merge_sort(right_arr)

    return merge(sorted_left_arr, sorted_right_arr)

def partition(arr:list[int], low:int, high:int)->list[int]:
    pivot = arr[high]
    i = low - 1

    for j in range(low, high):
        if arr[j] <= pivot:
            i = i + 1
            arr[i], arr[j] = arr[j], arr[i]

    arr[i + 1], arr[high] = arr[high], arr[i + 1]

    return i + 1

def quick_sort(arr:list[int], low:int, high:int)->list[int]:
    if low < high:
        pi = partition(arr, low, high)

        quick_sort(arr, low, pi - 1)
        quick_sort(arr, pi + 1, high)

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
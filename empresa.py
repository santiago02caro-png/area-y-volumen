class Empresa: 
 
    def __init__(self, nombre, descripcion, patrimonio): 
        # Guardamos los datos principales de la empresa
        self.__nombre = nombre 
        self.__descripcion = descripcion 
        self.__patrimonio = patrimonio 

        # Creamos las listas donde se almacenaran los objetos de la empresa
        self.__empleados = [] 
        self.__equipos = [] 
        self.__cuentas = [] 
 
    # getters: permiten consultar los atributos privados
 
    def get_nombre(self): 
        return self.__nombre 
 
    def get_descripcion(self): 
        return self.__descripcion 
 
    def get_patrimonio(self): 
        return self.__patrimonio 
 
    # Se usa copy para entregar una copia de la lista y no modificar directamente
    # la lista privada de la empresa
    def get_empleados(self): 
        return self.__empleados.copy() 
 
    def get_equipos(self): 
        return self.__equipos.copy() 
 
    def get_cuentas(self): 
        return self.__cuentas.copy() 
         
    # setters: permiten modificar los atributos privados
 
    def set_nombre(self, nombre): 
        self.__nombre = nombre 
 
    def set_descripcion(self, descripcion): 
        self.__descripcion = descripcion 
 
    def set_patrimonio(self, patrimonio): 
        self.__patrimonio = patrimonio 
 
    # Empleados 
 
    # Agrega un empleado a la lista de empleados
    def agregar_empleado(self, empleado): 
        self.__empleados.append(empleado) 
 
    # Busca un empleado usando su posicion en la lista
    def buscar_empleado(self, posicion): 
        if 0 <= posicion < len(self.__empleados): 
            return self.__empleados[posicion] 
        return None 
 
    # Reemplaza los datos del empleado que se encuentra en la posicion indicada
    def editar_empleado(self, posicion, empleado): 
        if 0 <= posicion < len(self.__empleados): 
            self.__empleados[posicion] = empleado 
            return True 
        return False 
 
    # Elimina el empleado que se encuentra en la posicion indicada
    def eliminar_empleado(self, posicion): 
        if 0 <= posicion < len(self.__empleados): 
            self.__empleados.pop(posicion) 
            return True 
        return False 
 
    # Equipos 
 
    # Agrega un equipo a la lista de equipos
    def agregar_equipo(self, equipo): 
        self.__equipos.append(equipo) 
 
    # Busca un equipo usando su posicion en la lista
    def buscar_equipo(self, posicion): 
        if 0 <= posicion < len(self.__equipos): 
            return self.__equipos[posicion] 
        return None 
 
    # Reemplaza los datos del equipo seleccionado
    def editar_equipo(self, posicion, equipo): 
        if 0 <= posicion < len(self.__equipos): 
            self.__equipos[posicion] = equipo 
            return True 
        return False 
 
    # Elimina el equipo seleccionado
    def eliminar_equipo(self, posicion): 
        if 0 <= posicion < len(self.__equipos): 
            self.__equipos.pop(posicion) 
            return True 
        return False 
 
    # Cuentas 
 
    # Agrega una cuenta bancaria a la lista
    def agregar_cuenta(self, cuenta): 
        self.__cuentas.append(cuenta) 
 
    # Busca una cuenta bancaria por su posicion
    def buscar_cuenta(self, posicion): 
        if 0 <= posicion < len(self.__cuentas): 
            return self.__cuentas[posicion] 
        return None 
 
    # Reemplaza la cuenta bancaria seleccionada
    def editar_cuenta(self, posicion, cuenta): 
        if 0 <= posicion < len(self.__cuentas): 
            self.__cuentas[posicion] = cuenta 
            return True 
        return False 
 
    # Elimina la cuenta bancaria seleccionada
    def eliminar_cuenta(self, posicion): 
        if 0 <= posicion < len(self.__cuentas): 
            self.__cuentas.pop(posicion) 
            return True 
        return False 
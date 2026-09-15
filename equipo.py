class Equipo:

    def __init__(self, nombre, descripcion, valor):
        self.__nombre = nombre
        self.__descripcion = descripcion
        self.__valor = valor

# getters

    def get_nombre(self):
        return self.__nombre

    def get_descripcion(self):
        return self.__descripcion

    def get_valor(self):
        return self.__valor
# setters
    def set_nombre(self, nombre):
        self.__nombre = nombre

    def set_descripcion(self, descripcion):
        self.__descripcion = descripcion

    def set_valor(self, valor):
        self.__valor = valor
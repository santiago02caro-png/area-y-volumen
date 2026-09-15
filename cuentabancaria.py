class CuentaBancaria:

    def __init__(self, banco, numero, saldo):
        self.__banco = banco
        self.__numero = numero
        self.__saldo = saldo

# getters 

    def get_banco(self):
        return self.__banco

    def get_numero(self):
        return self.__numero

    def get_saldo(self):
        return self.__saldo
# seterres 
    def set_banco(self, banco):
        self.__banco = banco

    def set_numero(self, numero):
        self.__numero = numero

    def set_saldo(self, saldo):
        self.__saldo = saldo
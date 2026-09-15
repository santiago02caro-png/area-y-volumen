from empresa import Empresa
from empleado import Empleado
from equipo import Equipo
from cuentabancaria import CuentaBancaria
from menu import menu_principal


# representamos la empresa con 
empresa = Empresa(
    "coca-cola",
    "la mejor gaseosa que probaras",
    500000000
)


# Creamos los objetos de tipo Empleado con sus datos
empleado1 = Empleado(
    "santiago caro",
    "jefe",
    6000000
)

empleado2 = Empleado(
    "pepe galindo",
    "Contador",
    3500000
)

# Agregamos los empleados a la empresa
empresa.agregar_empleado(empleado1)
empresa.agregar_empleado(empleado2)


# Creamos los objetos de tipo Equipo
equipo1 = Equipo(
    "Computador",
    "Computador para el jefe",
    2500000
)

equipo2 = Equipo(
    "gaseosa",
    "pa refrescar al jefe",
    3500000
)

# Agregamos los equipos a la empresa
empresa.agregar_equipo(equipo1)
empresa.agregar_equipo(equipo2)


# Creamos una cuenta bancaria con sus datos
cuenta1 = CuentaBancaria(
    "davivienda",
    "3253330938",
    20000000
)

# Agregamos la cuenta bancaria a la empresa
empresa.agregar_cuenta(cuenta1)


# Llamamos al menu principal y le enviamos la empresa
# para poder trabajar con sus empleados, equipos y cuentas
menu_principal(empresa)
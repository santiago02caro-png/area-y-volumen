from empleado import Empleado
from equipo import Equipo
from cuentabancaria import CuentaBancaria


# Esta funcion pausa el programa para poder leer el resultado
def pausa():
    input("\nPresione ENTER para continuar...")


def menu_empleados(empresa):

    while True:
        print("\n--- MENU EMPLEADOS ---")
        print("1. Agregar")
        print("2. Buscar")
        print("3. Editar")
        print("4. Eliminar")
        print("5. Listar")
        print("6. Volver")

        opcion = input("Seleccione una opcion: ")

        if opcion == "1":
            nombre = input("Nombre: ")
            cargo = input("Cargo: ")
            sueldo = float(input("Sueldo: "))

            # creo empleado con ell fin de podr guardar sus datos
            empleado = Empleado(nombre, cargo, sueldo)

            # guardamos el empleado en la empresa
            empresa.agregar_empleado(empleado)

            print("Empleado agregado.")
            pausa()

        elif opcion == "2":
            empleados = empresa.get_empleados()

            if len(empleados) == 0:
                print("No hay empleados.")
            else:
                for i, empleado in enumerate(empleados):
                    print(i, empleado.get_nombre())

                numero = int(input("Numero del empleado: "))

                # esto lo usamos para buscar al empleado dependiendo el numero de lista o posicion
                empleado = empresa.buscar_empleado(numero)

                if empleado is not None:
                    print("Nombre:", empleado.get_nombre())
                    print("Cargo:", empleado.get_cargo())
                    print("Sueldo:", empleado.get_sueldo())
                else:
                    print("Numero no valido.")

            pausa()

        elif opcion == "3":
            empleados = empresa.get_empleados()

            if len(empleados) == 0:
                print("No hay empleados.")
            else:
                for i, empleado in enumerate(empleados):
                    print(i, empleado.get_nombre())

                numero = int(input("Numero del empleado: "))
                nombre = input("Nuevo nombre: ")
                cargo = input("Nuevo cargo: ")
                sueldo = float(input("Nuevo sueldo: "))

                nuevo = Empleado(nombre, cargo, sueldo)

                # con esto editamos para remplazar al empleado
                if empresa.editar_empleado(numero, nuevo):
                    print("Empleado actualizado.")
                else:
                    print("Numero no valido.")

            pausa()

        elif opcion == "4":
            empleados = empresa.get_empleados()

            if len(empleados) == 0:
                print("No hay empleados.")
            else:
                for i, empleado in enumerate(empleados):
                    print(i, empleado.get_nombre())

                numero = int(input("Numero del empleado: "))

                # eliminacion de registro 
                if empresa.eliminar_empleado(numero):
                    print("Empleado eliminado.")
                else:
                    print("Numero no valido.")

            pausa()

        elif opcion == "5":
            empleados = empresa.get_empleados()

            if len(empleados) == 0:
                print("No hay empleados.")
            else:
                for i, empleado in enumerate(empleados):
                    print(i, empleado.get_nombre(),
                          empleado.get_cargo(),
                          empleado.get_sueldo())

            pausa()

        elif opcion == "6":
            break

        else:
            print("Opcion no valida.")


def menu_equipos(empresa):

    while True:
        print("\n--- MENU EQUIPOS ---")
        print("1. Agregar")
        print("2. Buscar")
        print("3. Editar")
        print("4. Eliminar")
        print("5. Listar")
        print("6. Volver")

        opcion = input("Seleccione una opcion: ")

        if opcion == "1":
            nombre = input("Nombre: ")
            descripcion = input("Descripcion: ")
            valor = float(input("Valor: "))

            equipo = Equipo(nombre, descripcion, valor)

            empresa.agregar_equipo(equipo)

            print("Equipo agregado.")
            pausa()

        elif opcion == "2":
            equipos = empresa.get_equipos()

            if len(equipos) == 0:
                print("No hay equipos.")
            else:
                for i, equipo in enumerate(equipos):
                    print(i, equipo.get_nombre())

                numero = int(input("Numero del equipo: "))

                equipo = empresa.buscar_equipo(numero)

                if equipo is not None:
                    print("Nombre:", equipo.get_nombre())
                    print("Descripcion:", equipo.get_descripcion())
                    print("Valor:", equipo.get_valor())
                else:
                    print("Numero no valido.")

            pausa()

        elif opcion == "3":
            equipos = empresa.get_equipos()

            if len(equipos) == 0:
                print("No hay equipos.")
            else:
                for i, equipo in enumerate(equipos):
                    print(i, equipo.get_nombre())

                numero = int(input("Numero del equipo: "))
                nombre = input("Nuevo nombre: ")
                descripcion = input("Nueva descripcion: ")
                valor = float(input("Nuevo valor: "))

                nuevo = Equipo(nombre, descripcion, valor)

                if empresa.editar_equipo(numero, nuevo):
                    print("Equipo actualizado.")
                else:
                    print("Numero no valido.")

            pausa()

        elif opcion == "4":
            equipos = empresa.get_equipos()

            if len(equipos) == 0:
                print("No hay equipos.")
            else:
                for i, equipo in enumerate(equipos):
                    print(i, equipo.get_nombre())

                numero = int(input("Numero del equipo: "))

                if empresa.eliminar_equipo(numero):
                    print("Equipo eliminado.")
                else:
                    print("Numero no valido.")

            pausa()

        elif opcion == "5":
            equipos = empresa.get_equipos()

            if len(equipos) == 0:
                print("No hay equipos.")
            else:
                for i, equipo in enumerate(equipos):
                    print(i, equipo.get_nombre(),
                          equipo.get_descripcion(),
                          equipo.get_valor())

            pausa()

        elif opcion == "6":
            break

        else:
            print("Opcion no valida.")


def menu_cuentas(empresa):

    while True:
        print("\n--- MENU CUENTAS BANCARIAS ---")
        print("1. Agregar")
        print("2. Buscar")
        print("3. Editar")
        print("4. Eliminar")
        print("5. Listar")
        print("6. Volver")

        opcion = input("Seleccione una opcion: ")

        if opcion == "1":
            banco = input("Banco: ")
            numero = input("Numero de cuenta: ")
            saldo = float(input("Saldo: "))

            cuenta = CuentaBancaria(banco, numero, saldo)

            empresa.agregar_cuenta(cuenta)

            print("Cuenta agregada.")
            pausa()

        elif opcion == "2":
            cuentas = empresa.get_cuentas()

            if len(cuentas) == 0:
                print("No hay cuentas.")
            else:
                for i, cuenta in enumerate(cuentas):
                    print(i, cuenta.get_banco())

                numero = int(input("Numero de la cuenta: "))

                cuenta = empresa.buscar_cuenta(numero)

                if cuenta is not None:
                    print("Banco:", cuenta.get_banco())
                    print("Numero:", cuenta.get_numero())
                    print("Saldo:", cuenta.get_saldo())
                else:
                    print("Numero no valido.")

            pausa()

        elif opcion == "3":
            cuentas = empresa.get_cuentas()

            if len(cuentas) == 0:
                print("No hay cuentas.")
            else:
                for i, cuenta in enumerate(cuentas):
                    print(i, cuenta.get_banco())

                numero = int(input("Numero de la cuenta: "))
                banco = input("Nuevo banco: ")
                nuevo_numero = input("Nuevo numero: ")
                saldo = float(input("Nuevo saldo: "))

                nueva = CuentaBancaria(banco, nuevo_numero, saldo)

                if empresa.editar_cuenta(numero, nueva):
                    print("Cuenta actualizada.")
                else:
                    print("Numero no valido.")

            pausa()

        elif opcion == "4":
            cuentas = empresa.get_cuentas()

            if len(cuentas) == 0:
                print("No hay cuentas.")
            else:
                for i, cuenta in enumerate(cuentas):
                    print(i, cuenta.get_banco())

                numero = int(input("Numero de la cuenta: "))

                if empresa.eliminar_cuenta(numero):
                    print("Cuenta eliminada.")
                else:
                    print("Numero no valido.")

            pausa()

        elif opcion == "5":
            cuentas = empresa.get_cuentas()

            if len(cuentas) == 0:
                print("No hay cuentas.")
            else:
                for i, cuenta in enumerate(cuentas):
                    print(i, cuenta.get_banco(),
                          cuenta.get_numero(),
                          cuenta.get_saldo())

            pausa()

        elif opcion == "6":
            break

        else:
            print("Opcion no valida.")


def menu_principal(empresa):

    while True:
        print("\n--- MENU PRINCIPAL ---")
        print("1. Empleados")
        print("2. Equipos")
        print("3. Cuentas bancarias")
        print("4. Salir")

        opcion = input("Seleccione una opcion: ")

        if opcion == "1":
            menu_empleados(empresa)

        elif opcion == "2":
            menu_equipos(empresa)

        elif opcion == "3":
            menu_cuentas(empresa)

        elif opcion == "4":
            print("Programa finalizado.")
            break

        else:
            print("Opcion no valida.")
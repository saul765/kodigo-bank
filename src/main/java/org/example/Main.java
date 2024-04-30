package org.example;

import org.example.base.Cliente;
import org.example.base.Cuenta;
import org.example.component.TableComponent;
import org.example.domain.Abonos;
import org.example.domain.ClientePersonaJuridica;
import org.example.domain.ClientePersonaNatural;
import org.example.domain.CuentaAhorros;
import org.example.repository.ClienteRepositoryImpl;
import org.example.repository.CuentasRepositoryImpl;
import org.example.repository.IClienteRepository;
import org.example.repository.ICuentasRepository;
import org.example.service.ClienteService;
import org.example.service.CuentasService;
import org.example.service.IClienteService;
import org.example.service.ICuentasService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Float MONTO_INICIAL = 1000f;

    private final Map<String, List<String>> tableHeaders = Map.of(
            "cliente-juridico", List.of("Id", "Nombre", "Apellido", "Documento", "Tipo"),
            "cuenta", List.of("Numero de cuenta", "Id Cliente", "Saldo", "Abonos"),
            "saldo", List.of("Saldo"),
            "abonos", List.of("Fecha abono", "Monto abono")
    );


    private ICuentasRepository cuentasRepository;

    private IClienteRepository clienteRepository;

    private ICuentasService cuentasService;

    private IClienteService clienteService;

    private TableComponent tableComponent = new TableComponent();


    public static void main(String[] args) {

        Main main = new Main();
        main.execute();

    }

    private void execute() {
        // Crear clientes
        ClientePersonaJuridica clientePersonaJuridica = new ClientePersonaJuridica("Juan", "Perez", "123456789");

        ClientePersonaNatural clientePersonaNatural = new ClientePersonaNatural("Saul", "Ramos", "050422317");

        // Crear cuentas
        Cuenta cuenta1 = new CuentaAhorros(clientePersonaJuridica, MONTO_INICIAL);

        Cuenta cuenta2 = new CuentaAhorros(clientePersonaNatural);

        ArrayList<Cuenta> cuentas = new ArrayList<>(List.of(cuenta1, cuenta2));

        ArrayList<Cliente> clientes = new ArrayList<>(List.of(clientePersonaJuridica, clientePersonaNatural));


        // Inicializar repositorios y servicios

        cuentasRepository = new CuentasRepositoryImpl(cuentas);

        clienteRepository = new ClienteRepositoryImpl(clientes);

        cuentasService = new CuentasService(cuentasRepository);

        clienteService = new ClienteService(clienteRepository);


        // Operaciones de cliente
        Cliente client = clienteService.getCliente("123456789");

        System.out.println("=========================== Información del cliente ===========================");

        tableComponent.createTable(tableHeaders.get("cliente-juridico"), List.of(client), cliente -> List.of(
                cliente.getId().toString(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getDocumento(),
                cliente.getTipoCliente().name()
        ));

        // Operaciones de cuenta

        System.out.println("=========================== Cuentas del cliente ===========================");


        List<Cuenta> cuentaCliente = cuentasService.getCuentasByClienteId(client.getId());

        tableComponent.createTable(tableHeaders.get("cuenta"), cuentaCliente, acc -> List.of(
                acc.getNumeroCuenta().toString(),
                acc.getCliente().getId().toString(),
                acc.getSaldo().toString(),
                acc.getAbonos().toString()

        ));

        System.out.println("=========================== Consulta Saldo ===========================");


        Float saldo = cuentasService.consultarSaldo(cuenta1.getNumeroCuenta());

        tableComponent.createTable(tableHeaders.get("saldo"), List.of(saldo), amount -> List.of(
                amount.toString()
        ));

        System.out.println("=========================== Realizar Abono ===========================");


        cuentasService.abonar(cuenta1.getNumeroCuenta(), 100f);

        System.out.println("Abono realizado de $100");

        System.out.println("=========================== Consulta Saldo ===========================");

        Float saldoConsulta = cuentasService.consultarSaldo(cuenta1.getNumeroCuenta());

        tableComponent.createTable(tableHeaders.get("saldo"), List.of(saldoConsulta), amount -> List.of(
                amount.toString()
        ));

        System.out.println("=========================== Historial abonos ===========================");


        List<Abonos> abonos = cuentasService.getHistorialAbonos(cuenta1.getNumeroCuenta());


        tableComponent.createTable(tableHeaders.get("abonos"), abonos, abono -> List.of(
                getFechaAbono(abono),
                abono.getMontoAbono().toString()

        ));

        System.out.println("=========================== Cuentas del cliente ===========================");

        List<Cuenta> cuentaClienteInvoke = cuentasService.getCuentasByClienteId(client.getId());

        tableComponent.createTable(tableHeaders.get("cuenta"), cuentaClienteInvoke, acc -> List.of(
                acc.getNumeroCuenta().toString(),
                acc.getCliente().getId().toString(),
                acc.getSaldo().toString(),
                acc.getAbonos().toString()

        ));
    }

    private String getFechaAbono(Abonos abonos) {
        return abonos.getFechaAbono().getDia() + "/" + abonos.getFechaAbono().getMes() + "/" + abonos.getFechaAbono().getAnio();
    }


}
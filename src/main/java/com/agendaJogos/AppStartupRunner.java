package com.agendaJogos;

import com.agendaJogos.services.DatabaseConnectionTesterService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStartupRunner implements CommandLineRunner {

    private final DatabaseConnectionTesterService connectionTesterService;

    public AppStartupRunner(DatabaseConnectionTesterService connectionTesterService) {
        this.connectionTesterService = connectionTesterService;
    }

    @Override
    public void run(String... args) {
        boolean isDatabaseConnected = connectionTesterService.testDatabaseConnection();

        if (isDatabaseConnected) {
            System.out.println("Conexão com o banco de dados estabelecida com sucesso.");
        } else {
            System.err.println("Erro ao estabelecer a conexão com o banco de dados.");
        }

    }
}

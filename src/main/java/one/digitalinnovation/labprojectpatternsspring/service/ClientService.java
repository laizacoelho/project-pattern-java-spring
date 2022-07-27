package one.digitalinnovation.labprojectpatternsspring.service;

import one.digitalinnovation.labprojectpatternsspring.model.Client;
import org.springframework.stereotype.Service;


public interface ClientService  {
    Iterable<Client> buscarTodos();

    Client buscarPorId(Long id);

    void inserir(Client client);

    void atualizar(Long id, Client client);

    void deletar(Long id);

}

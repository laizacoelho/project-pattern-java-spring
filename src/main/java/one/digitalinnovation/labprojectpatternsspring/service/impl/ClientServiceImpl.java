package one.digitalinnovation.labprojectpatternsspring.service.impl;

import one.digitalinnovation.labprojectpatternsspring.model.Endereco;
import one.digitalinnovation.labprojectpatternsspring.model.EnderecoRrepository;
import one.digitalinnovation.labprojectpatternsspring.model.Client;
import one.digitalinnovation.labprojectpatternsspring.model.ClientRepository;
import one.digitalinnovation.labprojectpatternsspring.service.ClientService;
import one.digitalinnovation.labprojectpatternsspring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private EnderecoRrepository enderecoRrepository;
    @Autowired
    private ViaCepService viaCepService;

    public ClientServiceImpl(ClientRepository clientRepository, EnderecoRrepository enderecoRrepository) {
        this.clientRepository = clientRepository;
        this.enderecoRrepository = enderecoRrepository;
    }

    @Override
    public Iterable<Client> buscarTodos(){
        return clientRepository.findAll();
    }

    @Override
    public Client buscarPorId(Long id){
        return clientRepository.findById(id).get();
    }

    @Override
    public void inserir(Client client){
        salvarClientComCep(client);
    }

    @Override
    public void atualizar(Long id, Client client){
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            salvarClientComCep(client);
        }
    }

    @Override
    public void deletar(Long id){
        clientRepository.deleteById(id);
    }

    private void salvarClientComCep(Client client) {
        String cep = client.getEndereco().getCep();
        Endereco endereco = enderecoRrepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRrepository.save(novoEndereco);
            return novoEndereco;
        });

        client.setEndereco(endereco);
        clientRepository.save(client);
    }
}

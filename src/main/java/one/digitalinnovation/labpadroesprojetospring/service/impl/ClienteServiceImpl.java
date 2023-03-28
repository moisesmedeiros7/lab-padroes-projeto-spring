package one.digitalinnovation.labpadroesprojetospring.service.impl;

import one.digitalinnovation.labpadroesprojetospring.model.Cliente;
import one.digitalinnovation.labpadroesprojetospring.model.Endereco;
import one.digitalinnovation.labpadroesprojetospring.model.ClienteRepository;
import one.digitalinnovation.labpadroesprojetospring.model.EnderecoRepository;
import one.digitalinnovation.labpadroesprojetospring.service.ClienteService;
import one.digitalinnovation.labpadroesprojetospring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    //TODO Singleton: Injetar os componentes do Spring com @Autowired
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    // TODO Strategy: Implementar os métodos definidos na interface
    // TODO Facade: Abstrair integrações com subsistemas, provendo uma interface simples

    @Override
    public Iterable<Cliente> buscarTodos() {
        // FIXME Buscar todos os clientes
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        //FIXME Buscar cliente por ID.
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return  cliente.get();
    }


    @Override
    public void inserir(Cliente cliente) {
        /**
         * FIXME Verificar se o Endereco do Cliente já existe (pelo CEP)
         * FIXME Caso não exista, integrar com o ViaCep e persistir retorno.
         * FIXME Inserir Cliente, vinculando o Endereco (novo ou existente)
         */
        //
        salvarClienteComCep(cliente);
        /*
        String cep = cliente.getEndereco().getCep();
        Endereco endereco =  enderecoRepository.findById(cep).orElseGet(() ->{ //buscando endereço no banco, caso não exista (orElseGet)...
            Endereco novoEndereco= viaCepService.consultarCep(cep);  // busca endereço no viacep
            enderecoRepository.save(novoEndereco);              // persiste o endereço no BD
            return novoEndereco;
         });
         cliente.setEndereco(endereco); //setando o endereço no cliente
         clienteRepository.save(cliente); //salvando cliente no BD
         */
    }


    // método utilitário
    private void salvarClienteComCep (Cliente cliente){
        //
        String cep = cliente.getEndereco().getCep();
        Endereco endereco =  enderecoRepository.findById(cep).orElseGet(() ->{ //buscando endereço no banco, caso não exista (orElseGet)...
            Endereco novoEndereco= viaCepService.consultarCep(cep);  // busca endereço no viacep
            enderecoRepository.save(novoEndereco);              // persiste o endereço no BD
            return novoEndereco;
        });
        cliente.setEndereco(endereco); //setando o endereço no cliente
        clienteRepository.save(cliente); //salvando cliente no BD
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        /**
         FIXME Buscar Cliente por ID, caso exista:
         FIXME verificar se o endereço do Cliente já existe (pelo CEP)
         FIXME Caso não exista, integrar com o ViaCEP e persistir retorno.
         FIXME Alterar Cliente, vinculando o Endereco (novo ou existente)
         **/
        Optional<Cliente> clientebd = clienteRepository.findById(id);
        if (clientebd.isPresent()){
            salvarClienteComCep(cliente);
        }

    }
    @Override
    public void deletar(Long id) {
        //FIXME Deletar cliente por ID.
        clienteRepository.deleteById(id);
    }
}

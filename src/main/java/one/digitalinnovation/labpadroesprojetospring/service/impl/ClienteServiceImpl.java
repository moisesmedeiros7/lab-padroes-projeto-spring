package one.digitalinnovation.labpadroesprojetospring.service.impl;

import one.digitalinnovation.labpadroesprojetospring.model.Cliente;
import one.digitalinnovation.labpadroesprojetospring.model.ClienteRepository;
import one.digitalinnovation.labpadroesprojetospring.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    // TODO Singleton: Injetar os componentes do Spring com @Autowired
    // TODO Strategy: Implementar os métodos definidos na interface
    // TODO Facade: Abstrair integrações com subsistemas, provendo uma interface simples
    @Autowired
    private ClienteRepository clienteRepository;

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


    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        /**
         FIXME Buscar Cliente por ID, caso exista:
         FIXME verificar se o endereço do Cliente já existe (pelo CEP)
         FIXME Caso não exista, integrar com o ViaCEP e persistir retorno.
         FIXME Alterar Cliente, vinculando o Endereco (novo ou existente)
         **/
    }

    @Override
    public void deletar(Long id) {
        //FIXME Deletar cliente por ID.
    }
}

package com.yllu.oath2project.security;

import com.yllu.oath2project.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;


public class ClientDetailsServiceJpa implements ClientDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDetails loadClientByClientId(String s) {
        return clientRepository.findClientByClientId(s)
                .orElseThrow(() -> new ClientRegistrationException("Client not found"));
    }
}

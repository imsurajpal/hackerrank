package com.suraj.controller

import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.databind.ObjectMapper
import com.suraj.config.WebConfig
import com.suraj.dao.ClientDaoImpl
import com.suraj.model.Client
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Ignore
import spock.lang.IgnoreIf
import spock.lang.Specification
import spock.lang.Unroll

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * Created by abhishek on 29/6/17.
 */

@WebAppConfiguration
@ContextConfiguration (classes = [WebConfig.class])
class ClientControllerTest extends Specification {


    @Autowired
    WebApplicationContext webApplicationContext

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ClientDaoImpl clientDao;

    JdbcTemplate jdbcTemplate;

    MockMvc mockMvc
    String resourceUri = "/client"



    void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .defaultRequest(post(resourceUri).contentType(MediaType.APPLICATION_JSON))
                .build();

        jdbcTemplate = clientDao.jdbcTemplate

        clientDao.jdbcTemplate = Mock(JdbcTemplate)


    }

    void cleanup() {
        clientDao.jdbcTemplate = jdbcTemplate

    }

    @Unroll
    def "Client controller unitTest should return client object on  client id #clientIdVal and clientName as #clientName"() {
        given: "given a client id"
        Integer clientId = clientIdVal;

        when: "a client controller is called"
        def request = get("${resourceUri}/${clientId}")
        def result = mockMvc.perform(request)


        then: "client id remains same as passed id"
        clientDao.jdbcTemplate.queryForObject (*_) >> new Client(id:clientIdVal,name:clientName,postalCode: 400101)

        Client client = objectMapper.readValue(result.andReturn().response.content.toByteArray(), Client.class)
        result.andExpect(status().is(200))
        client.id == clientIdVal;

        where:
        clientIdVal | clientName
        2           | "Abhishek"
        3           | "ram"
    }

    def "Client controller unitTest should save client object on post"() {
        given: "given a client id"
        def clientPayload = TestHelper.clientPayload;

        when: "a client controller is called"
        def request = post("${resourceUri}").content(clientPayload)
        def result = mockMvc.perform(request)


        then: "client id remains same as passed id"
         clientDao.jdbcTemplate.update(_ as String, _ as Object[]) >> null

        result.andExpect(status().is(200))
    }



    def "Client controller unitTest should update client object on  client id #clientIdVal and clientName as #clientName"() {
        given: "given a client id"
        def clientPayload = TestHelper.clientPayload;
        Integer clientId = 11;

        when: "a client controller is called"
        def request = put("${resourceUri}/${clientId}").content(clientPayload)
        def result = mockMvc.perform(request)


        then: "client id remains same as passed id"
        clientDao.jdbcTemplate.update(*_) >> null

        result.andExpect(status().is(200))

    }


    def "Client controller unitTest should delete client object on  client id #clientIdVal and clientName as #clientName"() {
        given: "given a client id"
        Integer clientId = 11;

        when: "a client controller is called"
        def request = delete("${resourceUri}/${clientId}")
        def result = mockMvc.perform(request)


        then: "client id remains same as passed id"
        clientDao.jdbcTemplate.queryForObject(*_)>> null


        result.andExpect(status().is(200))

    }








    @Unroll
    @Ignore
    def "Client controller should return client object on  client id #clientIdVal and clientName as #clientName"() {
        given: "given a client id"
        Integer clientId = clientIdVal;

        when: "a client controller is called"
        def request = get("${resourceUri}/${clientId}")

        def result = mockMvc.perform(request)

        then: "client id remains same as passed id"
        Client client = objectMapper.readValue(result.andReturn().response.content.toByteArray(), Client.class)
        result.andExpect(status().is(200))
        client.id == clientIdVal;

        where:
        clientIdVal | clientName
        2           | "Abhishek"
        3           | "ram"
    }


//    @Unroll
//    def "Client controller should return client object on  client id #clientIdVal and clientName as #clientName"() {
//        given: "given a client id"
//        Integer clientId = clientIdVal;
//        ClientController clientController = new ClientController()
//
//        when: "a client controller is called"
//        Client client = clientController.getClient(clientIdVal)
//
//        then: "client id remains same as passed id"
//        client.id == clientIdVal
//        client.name == clientName
//
//
//        where:
//        clientIdVal | clientName
//        2           | "Abhishek"
//        3           | "ram"
//    }


}

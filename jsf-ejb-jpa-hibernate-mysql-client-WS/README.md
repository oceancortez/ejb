# ejb
Criando um WS Client

Se você tiver com a jdk instalada na máquina, executar esse comando:
wsimport -keep -verbose http://localhost:8087/teste?wsdl

ou

Usar a ferrmenta SOAPUI para gerar os artefatos.

Depois disso basta jogar os aterfatos no projto e usar conforme ex:

@Test
public void testMarina() {

test.br.com.tokiomarine.seguradora.ssv.oc.ConsultasPeopleWebService port = new ConsultasPeopleWebService_Service()
	.getBrComTokiomarineSeguradoraSsvConsultasWebserviceConsultasPeopleWebService();

if (port != null) {
    test.br.com.tokiomarine.seguradora.ssv.oc.AssistenciaMarinaDTO buscaAssistenciaMarina = port
	    .buscaAssistenciaMarina(22906655L, 0L);
    Assert.assertTrue(buscaAssistenciaMarina != null);
}

}

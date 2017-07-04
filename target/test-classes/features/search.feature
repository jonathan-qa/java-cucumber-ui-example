Feature: As a researcher, I want to search content at Google

	Scenario: I want to search using a keyword
		Given I want to search "Testes Automatizados" at Google
		When I choose option Search
		Then results must be returned
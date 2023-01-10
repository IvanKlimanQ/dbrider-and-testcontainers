package com.example.dbriderandtestcontainers;

import com.example.dbriderandtestcontainers.controller.PersonController;
import com.example.dbriderandtestcontainers.model.PersonModel;
import com.example.dbriderandtestcontainers.util.UuidGenerator;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.junit5.api.DBRider;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.MSSQLServerContainer;
import org.testcontainers.utility.DockerImageName;

import java.util.UUID;

@SpringBootTest
@ActiveProfiles("test")
@DBRider
class ApplicationTests {

	@MockBean
	private UuidGenerator uuidGenerator;

	@Autowired
	PersonController personController;


	static {
		DockerImageName myImage = DockerImageName.parse("mcr.microsoft.com/mssql/server:2017-latest")
				.asCompatibleSubstituteFor("mcr.microsoft.com/mssql/server");
		MSSQLServerContainer database = new MSSQLServerContainer(myImage);
		database.start();

		System.setProperty("spring.datasource.url", database.getJdbcUrl());
	}

	@Test
	@DataSet(value = "example-data-create.yml", cleanBefore = true)
	@ExpectedDataSet("example-expected-create.yml")
	void dataShouldBeCreatedInTheDatabase() {
		Mockito.when(this.uuidGenerator.generateUuid()).
				thenReturn(UUID.fromString("5a8d68c8-2f28-4b53-ac5a-2db586512438"));
		this.personController.createPerson(
				new PersonModel(
						"Random",
						"Lady",
						"DiCaprioGF",
						25L,
						true
				)
		);
	}

	@Test
	@DataSet(value = "example-data-update.yml", cleanBefore = true)
	@ExpectedDataSet("example-expected-update.yml")
	void dataShouldBeUpdatedInTheDatabase() {
		this.personController.updatePerson(
				new PersonModel(
						UUID.fromString("5a8d68c8-2f28-4b53-ac5a-2db586512438"),
						"Random",
						"Lady",
						"DiCaprioGFNoMore",
						26L,
						false
				)
		);
	}

	@Test
	@DataSet(value = "example-data-delete.yml", cleanBefore = true)
	@ExpectedDataSet("example-expected-delete.yml")
	void dataShouldBeDeletedInTheDatabase() {
		this.personController.deletePerson(
				UUID.fromString("5a8d68c8-2f28-4b53-ac5a-2db586512438")
		);
	}

}

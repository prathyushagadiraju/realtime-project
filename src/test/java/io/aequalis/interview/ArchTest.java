package io.aequalis.interview;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("io.aequalis.interview");

        noClasses()
            .that()
            .resideInAnyPackage("io.aequalis.interview.service..")
            .or()
            .resideInAnyPackage("io.aequalis.interview.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..io.aequalis.interview.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}

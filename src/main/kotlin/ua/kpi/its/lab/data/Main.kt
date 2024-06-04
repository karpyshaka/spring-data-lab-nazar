package ua.kpi.its.lab.data

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import ua.kpi.its.lab.data.entity.SoftwareModule
import ua.kpi.its.lab.data.entity.SoftwareProduct
import ua.kpi.its.lab.data.svc.SoftwareProductService
import java.util.*

fun main() {
    val context = AnnotationConfigApplicationContext("ua.kpi.its.lab")
    val softwareProductService = context.getBean(SoftwareProductService::class.java)

    val module1 = SoftwareModule("Description 1", "Author 1", "Java", Date(), 10.0, 100, true)
    val module2 = SoftwareModule("Description 2", "Author 2", "Python", Date(), 15.0, 200, false)

    val product1 = SoftwareProduct("Product 1", "Developer 1", "1.0", Date(), 500.0, true, true, module1)
    val product2 = SoftwareProduct("Product 2", "Developer 2", "1.1", Date(), 300.0, true, false, module2)
    val product3 = SoftwareProduct("Product 3", "Developer 3", "2.0", Date(), 700.0, false, true, module1)
    val product4 = SoftwareProduct("Product 4", "Developer 4", "2.1", Date(), 800.0, true, true, module2)
    val product5 = SoftwareProduct("Product 5", "Developer 5", "3.0", Date(), 1000.0, false, false, module1)

    // Додавання сутностей в БД
    softwareProductService.create(product1)
    softwareProductService.create(product2)
    softwareProductService.create(product3)
    softwareProductService.create(product4)
    softwareProductService.create(product5)

    // Отримання сутності з індексом 3
    val product = softwareProductService.readById(3)
    println("Product with id 3: $product")

    // Видалення сутності з індексом 4
    softwareProductService.deleteById(4)
    println("Product with id 4 has been deleted")
}

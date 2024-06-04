package ua.kpi.its.lab.data.svc.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ua.kpi.its.lab.data.entity.SoftwareProduct
import ua.kpi.its.lab.data.repo.SoftwareProductRepository
import ua.kpi.its.lab.data.svc.SoftwareProductService

@Service
class SoftwareProductServiceImpl @Autowired constructor(
    private val repository: SoftwareProductRepository
) : SoftwareProductService {
    override fun create(softwareProduct: SoftwareProduct): SoftwareProduct {
        return repository.save(softwareProduct)
    }

    override fun read(): List<SoftwareProduct> {
        return repository.findAll()
    }

    override fun readById(id: Long): SoftwareProduct? {
        return repository.findById(id).orElse(null)
    }

    override fun updateById(id: Long, softwareProduct: SoftwareProduct): SoftwareProduct? {
        return if (repository.existsById(id)) {
            softwareProduct.id = id
            repository.save(softwareProduct)
        } else {
            null
        }
    }

    override fun deleteById(id: Long): SoftwareProduct? {
        return repository.findById(id).orElse(null)?.also {
            repository.delete(it)
        }
    }
}

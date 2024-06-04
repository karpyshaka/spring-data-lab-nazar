package ua.kpi.its.lab.data.svc

import ua.kpi.its.lab.data.entity.SoftwareProduct

interface SoftwareProductService {
    fun create(softwareProduct: SoftwareProduct): SoftwareProduct
    fun read(): List<SoftwareProduct>
    fun readById(id: Long): SoftwareProduct?
    fun updateById(id: Long, softwareProduct: SoftwareProduct): SoftwareProduct?
    fun deleteById(id: Long): SoftwareProduct?
}

package ua.kpi.its.lab.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import ua.kpi.its.lab.data.entity.SoftwareProduct
import ua.kpi.its.lab.data.entity.SoftwareModule

interface SoftwareProductRepository : JpaRepository<SoftwareProduct, Long>


interface SoftwareModuleRepository : JpaRepository<SoftwareModule, Long>

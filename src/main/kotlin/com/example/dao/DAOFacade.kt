package com.example.dao

import com.example.model.Disp_loginhist

interface DAOFacade {
    suspend fun getByUserId(userId: String): List<Disp_loginhist>
}
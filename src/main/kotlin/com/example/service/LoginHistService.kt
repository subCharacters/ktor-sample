package com.example.service

import com.example.dao.DAOFacadeImpl

class LoginHistService {
    suspend fun getByUserId(userid: String) = DAOFacadeImpl().getByUserId(userid)
}
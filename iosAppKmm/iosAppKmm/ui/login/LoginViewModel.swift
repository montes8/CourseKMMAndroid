//
//  LoginViewModel.swift
//  iosAppKmm
//
//  Created by MacBook Pro on 12/08/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

class LoginViewModel : ObservableObject{
    
    @Published var showingAlert: Bool = false
    @Published var errorMesagge: String = "Ocurrio un error"
    
    let useUseCase = UseUseCase()
    
   
    @Published var appEventLogin: LoginEvent = .Default {
        didSet {
            objectWillChange.send()
        }
    }
    
    func nextRegister(){
        self.appEventLogin = LoginEvent.Register
    }
    
    
    @MainActor // MainActor es un singleton que ejecuta código en el hilo principal.
    func validateUser(user : String,pass : String) {
        print("logindata "+user + "  " + pass)
        Task {
            do {
                let response = try await useUseCase.login(user: user, pass: pass)
                if response != nil{
                    self.appEventLogin = LoginEvent.Home
                }else{
                    self.appEventLogin = LoginEvent.Error
                    self.showingAlert = true
                    self.errorMesagge = "Usuario no registrado"
                }
            
            } catch {
                appEventLogin = .Error
                showingAlert = true
                self.errorMesagge = "Ocurrio un error en la petición"
            }
    
        }
    }
}


enum LoginEvent {
    case Home
    case Register
    case Error
    case Default
}

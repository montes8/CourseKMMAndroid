//
//  RegisterViewModel.swift
//  iosAppKmm
//
//  Created by MacBook Pro on 12/08/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

class RegisterViewModel : ObservableObject{
    
    @Published var showingAlertR: Bool = false
    @Published var errorMesaggeR: String = "Ocurrio un error"
    
    let useUseCase = UseUseCase()
    
    @Published var appEventLogin: LoginEvent = .Register {
        didSet {
            objectWillChange.send()
        }
    }
    

    
    @MainActor
    func registerUser(user : String,pass : String) {
        print("logindata "+user + "  " + pass)
        Task {
            do {
                let response = try await useUseCase.register(user: user, pass: pass, token: "hgfdfg")
                if response as! Bool {
                         self.appEventLogin = LoginEvent.Home
                         self.showingAlertR = true
                         self.errorMesaggeR = "Usuario  registrado"
                         
                     }else{
                         self.appEventLogin = LoginEvent.Error
                         self.showingAlertR = true
                         self.errorMesaggeR = "Usuario no registrado"
                     }
                
            
            } catch {
                appEventLogin = .Error
                showingAlertR = true
                print(error.localizedDescription)
                self.errorMesaggeR = "Ocurrio un error en la petición"
            }
    
        }
    }
}

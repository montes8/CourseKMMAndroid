//
//  LoginScreen.swift
//  iosAppKmm
//
//  Created by MacBook Pro on 11/08/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct LoginScreen: View {
        
    let placeHolder: String = "usuario"
    @State var textValue: String = "Tayler"
    
    let placeHolderPass: String = "contraseña"
    @State var textValuePass: String = "Tayler"
    
    @ObservedObject var viewModel: LoginViewModel = LoginViewModel()
    
    var body: some View {
        NavigationView{
            
            VStack(spacing: 20) {
                
                TextInputLayout(hint: placeHolder, textValue: $textValue)
                TextInputLayout(hint: placeHolderPass, textValue: $textValuePass)
                Button("Iniciar Sesiòn") {
                    viewModel.validateUser(user: textValue, pass: textValuePass)
                }.padding(12).background(Color.blue) // If you have this
                    .cornerRadius(25).foregroundColor(.white)
                
                Button("Crear Cuenta") {
                    viewModel.nextRegister()
                }
                .cornerRadius(25).foregroundColor(.blue)
                if viewModel.appEventLogin == LoginEvent.Register {
                              DelayedNavigationLink(delay: .seconds(0)) {RegisterScreem()}
                    
                          }else if viewModel.appEventLogin == LoginEvent.Home {
                             
                        DelayedNavigationLink(delay: .seconds(0)) {HomeScreem()}
                            
                }
                
            }.padding(20)
                .alert(isPresented: $viewModel.showingAlert) {
                    Alert(title: Text("CourseKmm"), message: Text(viewModel.errorMesagge), dismissButton: .default(Text("Aceptar")))
                }
          
                     
        }.navigationTitle("").navigationBarBackButtonHidden(true)
        
    }
}


struct LoginScreen_Previews: PreviewProvider {
    static var previews: some View {
         LoginScreen()
    }
}

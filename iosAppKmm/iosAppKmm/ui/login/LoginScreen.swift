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
    
    
    var body: some View {
        NavigationView{
            VStack(spacing: 20) {
                TextInputLayout(hint: placeHolder, textValue: $textValue)
                TextInputLayout(hint: placeHolderPass, textValue: $textValuePass)
                NavigationLink(destination: HomeScreem()) {
                    Text("Iniciar Sesiòn").padding(12).background(Color.blue) // If you have this
                        .cornerRadius(25).foregroundColor(.white)
                }
                
                Button("Crear Cuenta") {
                   
                }.cornerRadius(25).foregroundColor(.blue)
            
                
            }.padding(20)
                     
        }.navigationTitle("").navigationBarBackButtonHidden(true)
        
    }
}

func TextInputLayout(hint : String,textValue: Binding<String>) -> some View{
    return ZStack(alignment: .leading) {
                Text(hint)
                    .foregroundColor(Color(.placeholderText))
                    .offset(y: textValue.wrappedValue.isEmpty ? 0 : -25)
                    .scaleEffect(textValue.wrappedValue.isEmpty ? 1: 0.8, anchor: .leading)
                TextField("", text: textValue)
            }
    .padding(.top, textValue.wrappedValue.isEmpty ? 0 : 15)
            .frame(height: 52)
            .padding(.horizontal, 16)
            .overlay(RoundedRectangle(cornerRadius: 12).stroke(lineWidth: 1).foregroundColor(.gray))
    
}

struct LoginScreen_Previews: PreviewProvider {
    static var previews: some View {
         LoginScreen()
    }
}

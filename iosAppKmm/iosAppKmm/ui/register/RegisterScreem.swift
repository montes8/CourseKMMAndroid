//
//  RegisterScreem.swift
//  iosAppKmm
//
//  Created by MacBook Pro on 12/08/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct RegisterScreem: View {
    
    
    @Environment(\.presentationMode) var presentationMode: Binding<PresentationMode>
    @Environment(\.managedObjectContext) var managedObjectContext
    let placeHolderR: String = "usuario"
    @State var textValueR: String = "Tayler"
    
    let placeHolderPassR: String = "contraseña"
    @State var textValuePassR: String = "Tayler"
    
    @StateObject var viewModel: RegisterViewModel = RegisterViewModel()
    
    var body: some View {
        NavigationView{
            
            VStack(spacing: 20) {
                ZStack(alignment: .leading) {
                            Text(placeHolderR)
                                .foregroundColor(Color(.placeholderText))
                                .offset(y: textValueR.isEmpty ? 0 : -25)
                                .scaleEffect(textValueR.isEmpty ? 1: 0.8, anchor: .leading)
                            TextField("", text: $textValueR)
                        }
                .padding(.top, textValueR.isEmpty ? 0 : 15)
                        .frame(height: 52)
                        .padding(.horizontal, 16)
                        .overlay(RoundedRectangle(cornerRadius: 12).stroke(lineWidth: 1).foregroundColor(.gray))
                        
                ZStack(alignment: .leading) {
                            Text(placeHolderPassR)
                                .foregroundColor(Color(.placeholderText))
                                .offset(y: textValuePassR.isEmpty ? 0 : -25)
                                .scaleEffect(textValuePassR.isEmpty ? 1: 0.8, anchor: .leading)
                            TextField("", text: $textValuePassR)
                        }
                .padding(.top, textValuePassR.isEmpty ? 0 : 15)
                        .frame(height: 52)
                        .padding(.horizontal, 16)
                        .overlay(RoundedRectangle(cornerRadius: 12).stroke(lineWidth: 1).foregroundColor(.gray))
                Button("Registrase") {
                    viewModel.registerUser(user: textValueR, pass: textValuePassR)
                }.padding(12).background(Color.blue) // If you have this
                    .cornerRadius(25).foregroundColor(.white)
                
            }.padding(20)
                .alert(isPresented: $viewModel.showingAlertR) {
                    Alert(title: Text("CourseKMM"), message: Text(viewModel.errorMesaggeR),
                        primaryButton: Alert.Button.default(Text("Aceptar"), action: {
                        if viewModel.appEventLogin == LoginEvent.Home {
                            presentationMode.wrappedValue.dismiss()
                        }
                        }),
                        secondaryButton: Alert.Button.cancel(Text("Cancelar"), action: {
                        if viewModel.appEventLogin == LoginEvent.Home {
                            presentationMode.wrappedValue.dismiss()
                        }
                        })
                    )
                }
            
            
            
        }.navigationTitle("Registro").navigationBarBackButtonHidden(true)
    }
}

struct RegisterScreem_Previews: PreviewProvider {
    static var previews: some View {
        RegisterScreem()
    }
}

//
//  HomeViewModel.swift
//  iosAppKmm
//
//  Created by MacBook Pro on 11/08/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared


class HomeViewModel : ObservableObject{
    
    @Published var showingAlert: Bool = false
    @Published var errorMesagge: String = "Ocurrio un error"
    @Published var listRecipe: [RecipeModel] = []
    
    let appUseCase = AppUseCase(context : NSObject())
    let dataUseCase = DataUseCase()
    
    init() {
        saveToke()
       }
    
    @MainActor // MainActor es un singleton que ejecuta código en el hilo principal.
    func loadListRecipes() {
        Task {
            do {
                let response = try await dataUseCase.loadRecipes()
                 self.listRecipe = response ?? []
            } catch {
                showingAlert = true
                print("error al consultar servicio")
                self.errorMesagge = "Ocurrio un error en la petición"
            }
    
        }
    }
    
    func saveToke(){
        appUseCase.saveToken(value: "kjhghjkjhgfdfgh")
    }
}

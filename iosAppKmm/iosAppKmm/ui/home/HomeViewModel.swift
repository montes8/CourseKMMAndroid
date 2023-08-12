//
//  HomeViewModel.swift
//  iosAppKmm
//
//  Created by MacBook Pro on 11/08/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared


class  HomeViewModel :ObservableObject{
    

    @Published var successToken : Bool = false
    let appUseCase = AppUseCase(context : NSObject())

    init() {
        saveToke()
       }
      

    func saveToke(){
        appUseCase.saveToken(value: "kjhghjkjhgfdfgh")
    }
    
}

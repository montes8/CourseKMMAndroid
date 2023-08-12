//
//  SplashScreen.swift
//  iosAppKmm
//
//  Created by MacBook Pro on 11/08/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct SplashScreen: View {
    
    @ObservedObject var splashViewModel = SplashViewModel()
    
    var body: some View {
        
        NavigationView {
            VStack(spacing: 16) {
                Text("FOOD MERIA").font(.system(size: 25,weight: .bold)).foregroundColor(.white)
                Text("BIENVENIDOS").font(.system(size: 20,weight: .bold)) .foregroundColor(.white)
                Text("HAS TU PEDIDO AHORA").font(.system(size: 20,weight: .bold)) .foregroundColor(.white)
                
                if splashViewModel.successToken{
                                     DelayedNavigationLink(delay: .seconds(3)) {HomeScreem()}
                                 }else{
                                     DelayedNavigationLink(delay: .seconds(3)) {LoginScreen()}
                                  }
                
            }.frame(
                maxWidth: .infinity,
                maxHeight: .infinity
            ).background(Color.blue.edgesIgnoringSafeArea(.all))
                 
        }
        
    }
}


struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        SplashScreen()
    }
}

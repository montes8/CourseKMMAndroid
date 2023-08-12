//
//  HomeScreem.swift
//  iosAppKmm
//
//  Created by MacBook Pro on 11/08/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct HomeScreem: View {
    
    @ObservedObject var homeViewModel = HomeViewModel()
    
    var body: some View {
        Text("Hello, Home!")
    }
}

struct HomeScreem_Previews: PreviewProvider {
    static var previews: some View {
        HomeScreem()
    }
}

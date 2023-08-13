//
//  HomeScreem.swift
//  iosAppKmm
//
//  Created by MacBook Pro on 11/08/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct HomeScreem: View {
    
    @StateObject var viewModel: HomeViewModel = HomeViewModel()
    
    var body: some View {
    
        NavigationView{
            VStack() {
                List(){
                    ForEach(viewModel.listRecipe, id: \.id){model in
                        VStack() {
                                HStack{
                                    Image(uiImage: model.urlImg.load()).resizable().frame(width: 100,height: 100)
                                    
                                        VStack(alignment: .leading, spacing: 0){
                                            Text(model.title).font(.system(size: 20,weight: .bold)).lineLimit(1).foregroundColor(.black)
                                            Text(model.description).font(.system(size: 16,weight: .bold)).lineLimit(5).foregroundColor(.black)
                                        }
               
                                }.padding(8).background(Color.gray).cornerRadius(20)
                        }.padding(4).listRowInsets(.init(top: 0, leading: 0, bottom: 0, trailing: 0))
                    }
                }.background(Color.white).cornerRadius(20).listStyle(PlainListStyle())
            } .frame(
                minWidth: 0,
                maxWidth: .infinity,
                minHeight: 0,
                maxHeight: .infinity,
                alignment: .topLeading
              )
              .background(Color.white).alert(isPresented: $viewModel.showingAlert) {
                Alert(title: Text("CourseKmm"), message: Text(viewModel.errorMesagge), dismissButton: .default(Text("Aceptar")))
            }
      
          
        }.navigationTitle("Home").navigationBarBackButtonHidden(true).onAppear{
            viewModel.loadListRecipes()
        }
        
    }
    
}

extension String{
    func load() -> UIImage {
        do{
            guard let url = URL(string: self) else { return UIImage()}
            let data : Data = try Data(contentsOf: url)
            return UIImage(data: data) ?? UIImage()
        }catch{
            
        }
        return UIImage()
    }
}


struct HomeView_Previews: PreviewProvider {
    static var previews: some View {
        HomeScreem()
    }
}

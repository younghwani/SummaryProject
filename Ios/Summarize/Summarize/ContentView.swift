//
//  ContentView.swift
//  Summarize
//
//  Created by kimyounghwan on 2021/10/13.
//

import SwiftUI

struct ContentView: View {
    
    @State var input: String = ""
    @State var output: String = ""
    
//    private var baseUrl: String = "http://127.0.0.1:8080/api/summary?text="
    
    private func requestData() {
        print("ContentView - requestData() called")
        
        var urlComponents = URLComponents(string: "http://127.0.0.1:8080/api/kobartSum?")
        let textQuery = URLQueryItem(name: "text", value: input)
        urlComponents?.queryItems?.append(textQuery)
        
        guard let url = URL(string: (urlComponents?.string)!) else {
            print("Invalid URL")
            return
        }
        
        var request = URLRequest(url: url)
        request.httpMethod = "GET"
        
        URLSession.shared.dataTask(with: request){ data, response, error in
            if let data = data {
                if let decodedData = try? JSONDecoder().decode(Summary.self, from: data) {
                    DispatchQueue.main.async {
                        self.output = decodedData.output
                        print(decodedData)
                    }
                    return
                }
            }
            print(error?.localizedDescription ?? "ERROR!")
        }.resume()
    }
    
    var body: some View {
        ScrollView(.vertical) {
            VStack(alignment: .leading) {
                HStack {
                    TextField("Enter Text...", text: $input)
                    Button(action: {
                        print("Summarize Button")
                        requestData()
                        input = ""
                    }, label: {
                        Text("Summarize")
                            .font(.system(size: 20))
                            .fontWeight(.bold)
                            .foregroundColor(.white)
                    })
                        .padding(10)
                        .background(Color.blue)
                        .cornerRadius(10)
                        
                }
                .padding(.bottom, 5)
                VStack(alignment:.leading, spacing: 10) {
                    Text("Output")
                        .fontWeight(.bold)
                        .font(.system(size: 30))
                    Text(output)
                }
            }
            .padding()
            .padding(.top, 10)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject private(set) var viewModel: ViewModel

    var body: some View {
        Text(viewModel.text)
    }
}

extension ContentView {
    class ViewModel: ObservableObject {
        @Published var text = "Loading..."
        init() {
            BankRepositoryImpl().getListBanks { banks, error in
                DispatchQueue.main.async {
                    if let banks = banks {
                        self.text = banks.map{"\($0.name ?? "empty")"}.joined(separator: "-")
                    } else {
                        self.text = error?.localizedDescription ?? "error"
                    }
                }
            }
        }
    }
}

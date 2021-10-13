//
//  Summary.swift
//  Summarize
//
//  Created by kimyounghwan on 2021/10/13.
//

import Foundation

struct Summary: Codable, Identifiable {
    let id: Int
    let input: String
    let output: String
}

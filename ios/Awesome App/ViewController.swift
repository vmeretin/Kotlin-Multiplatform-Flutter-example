//
//  ViewController.swift
//  Awesome App
//
//  Created by Vladislav Boyko on 23/01/2019.
//  Copyright © 2019 Vladislav Boyko. All rights reserved.
//

import UIKit
import Flutter
import commonLibrary

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        print("hello \(SampleKt.hello())")
        let flutterEngine = (UIApplication.shared.delegate as? AppDelegate)?.flutterEngine;
        let flutterViewController = FlutterViewController(engine: flutterEngine, nibName: nil, bundle: nil)!;
        self.present(flutterViewController, animated: true, completion: nil)
        let channel = FlutterMethodChannel(name: "habr.example.flutter/hello", binaryMessenger: flutterViewController)
        channel.setMethodCallHandler {
            (call: FlutterMethodCall, result: FlutterResult) -> Void in
            switch (call.method) {
            case "getHello": result(SampleKt.hello())
            default: result(FlutterMethodNotImplemented)
            }
        }
    }


}


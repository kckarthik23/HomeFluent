const path = require("path");
var HtmlWebpackPlugin = require('html-webpack-plugin');
module.exports = {
    entry: "./src/public/scripts/app.js",
    output: {
        path: path.join(__dirname, "target"),
        filename: "bundle.js"
    }
    ,
    plugins: [
        new HtmlWebpackPlugin({
            template: './index.html'
        })
    ],
    module: {
        rules: [{

            test: /\.js$|jsx/,
            exclude: path.join(__dirname, "node_modules"),
            use: {
                loader: 'babel-loader',
                options: {
                    presets: ['@babel/preset-env', '@babel/preset-react']
                }
            }

        }

        ]
    },
    devtool: 'source-map',
    devServer: {
        static: {
            directory: path.join(__dirname, "target")
        },
        port: 8000, 
        historyApiFallback:true// default 8000
    }

};
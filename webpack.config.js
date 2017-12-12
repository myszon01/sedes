var path = require('path');

module.exports = {
  entry: './src/main/resources/static/js/app.js',
  devtool: 'sourcemaps',
  cache: true,
  debug: true,
  output: {
    path: __dirname + '/src/main/webapp/public', 
    filename: 'bundle.js' 
  },
  module: {
	    loaders: [
	      {
	    	  test: path.join(__dirname, '.'),
              exclude: /(node_modules)/,
              loader: 'babel-loader',
              query: {
                  cacheDirectory: true,
                  presets: ['es2015', 'react']
              }
	      }
	    ]
	  }
	  
	}
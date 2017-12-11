

module.exports = {
  entry: './src/main/resources/static/js/app.js',
  output: {
    path: __dirname + '/src/main/webapp/public', 
    filename: 'bundle.js' 
  },
  module: {
	    loaders: [
	      {
	        test: /.js$/,
	        loader: 'babel',
	        exclude: /node_modules/,
	        query: {
	          presets: ['es2015', 'react']
	        }
	      }
	    ]
	  }
	  
	}
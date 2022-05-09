console.log("register log")

var app = new Vue({
	el: '#register',
	data() {
		return {
		    user : {}
		}
	},
	mounted() {

	},
	methods: {

	    register () {
	    console.log('register method')
	    	axios.post('/public/register', this.user)
        		.then(response => {
        		console.log(response)
        		});
	    }

	}
});

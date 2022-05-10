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

	    function register () {
	    console.log('register method')
	    setTimeout(() => {  console.log("START!"); }, 5000);
	    	axios.post('/public/register', this.user)
        		.then(response => {
        		console.log(response)
        		});
        setTimeout(() => {  console.log("END!"); }, 5000);

	    }

	}
});

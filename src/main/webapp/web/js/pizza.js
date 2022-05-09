console.log("all pizza")

var app = new Vue({
	el: '#allpizza',
	data() {
        return {
            pizzas : []
        }
	},
	mounted() {

          axios.get('/user/pizza')
          		.then(response => {
          		    data = response.data
          		    console.log(data)
          		    data.forEach(element =>

          		        console.log(element)

          		    );

          		    this.pizzas = response.data;
          		});

	},
	methods: {



	}
});

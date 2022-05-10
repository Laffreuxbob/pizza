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
          		    pizzas = response.data
          		    console.log(pizzas)
          		    pizzas.forEach(element =>

          		        console.log(element)

          		    );

          		    this.pizzas = pizzas;
          		});

	},
	methods: {



	}
});

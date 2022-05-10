console.log("custom pizza")

var app = new Vue({
	el: '#crudpizza',
	data() {
        return {
            newpizza : {},
            ingredients : [],
            newname_ : [],
            newingredients_ : []
        }
	},
	mounted() {

          axios.get('/admin/crudpizza')
          		.then(response => {
//          		    console.log(response.data)
//          		    response.data.forEach(element =>
//          		        console.log(element)
//          		    );
          		    this.ingredients = response.data;
          		});

	},
	methods: {
             createPizza () {
                   var newname_ = document.getElementById("newname_").value;
                   this.newpizza.name = newname_

                   var list_ingr = document.getElementById("ingredientForm");
                   for (let i = 0; i < list_ingr.children.length; i++) {
                        console.log(i)
                        var temp_checkbox = list_ingr.children[i]
                        console.log(temp_checkbox)
                        if(temp_checkbox.checked == True)  {
                            console.log(temp_checkbox.name)
                            this.newingredients_.push(temp_checkbox.name)
                        }
                   }

                   this.newpizza.ingredient = this.newingredients_
                   console.log('-------------------------')
                   console.log('-------------------------')
                   console.log('-------------------------')

                   console.log('-------------------------')
                   console.log(this.newpizza)
                   console.log('-------------------------')
                   console.log('-------------------------')
                   console.log('-------------------------')
                   console.log('-------------------------')

                   for (let j = 0; i < 10; j++) { console.log(j) }

             }

	}
});

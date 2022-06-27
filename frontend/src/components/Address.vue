<template>


    <v-card outlined>
        <v-card-title>
            Address
        </v-card-title>

        <v-card-text>
            <String label="Street" v-model="value.street" :editMode="editMode"/>
            <String label="City" v-model="value.city" :editMode="editMode"/>
            <String label="State" v-model="value.state" :editMode="editMode"/>
            <String label="Country" v-model="value.country" :editMode="editMode"/>
            <String label="ZipCode" v-model="value.zipcode" :editMode="editMode"/>

        </v-card-text>

        <v-card-actions v-if="inList">
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="edit"
                    v-if="!editMode"
            >
                Edit
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="add"
                    v-else
            >
                Add
            </v-btn>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="remove"
                    v-if="!editMode"
            >
                Delete
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>

    export default {
        name: 'Address',
        components:{},
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
            inList: Boolean,
            label: String,
        },
        data: () => ({
        }),
        async created() {
            if(!this.value) {
                this.$emit('input', {});
                this.newValue = {
                    'street': '',
                    'city': '',
                    'state': '',
                    'country': '',
                    'zipcode': '',
                }
            }
            if(typeof this.value === 'object') {
                if(!('street' in this.value)) {
                    this.value.street = null;
                }
                if(!('city' in this.value)) {
                    this.value.city = null;
                }
                if(!('state' in this.value)) {
                    this.value.state = null;
                }
                if(!('country' in this.value)) {
                    this.value.country = null;
                }
                if(!('zipcode' in this.value)) {
                    this.value.zipcode = null;
                }
            }
            
        },
        watch: {
            value(val) {
                this.$emit('input', val);
            },
            newValue(val) {
                this.$emit('input', val);
            },
        },

        methods: {
            edit() {
                this.editMode = true;
            },
            async add() {
                this.editMode = false;
                this.$emit('input', this.value);

                if(this.isNew){
                    this.$emit('add', this.value);
                } else {
                    this.$emit('edit', this.value);
                }
            },
            async remove(){
                this.editMode = false;
                this.isDeleted = true;

                this.$emit('input', this.value);
                this.$emit('delete', this.value);
            },
            change(){
                this.$emit('change', this.value);
            },
        }
    }
</script>


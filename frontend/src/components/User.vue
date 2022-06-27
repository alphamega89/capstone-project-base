<template>


    <v-card outlined>
        <v-card-title>
            User
        </v-card-title>

        <v-card-text>
            <String label="Password" v-model="value.password" :editMode="editMode"/>
            <String label="Name" v-model="value.name" :editMode="editMode"/>
            <String label="Email" v-model="value.email" :editMode="editMode"/>
            <String label="Address" v-model="value.address" :editMode="editMode"/>
            <String label="Phone" v-model="value.phone" :editMode="editMode"/>

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
        name: 'User',
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
                    'id': '',
                    'password': '',
                    'name': '',
                    'email': '',
                    'address': '',
                    'phone': '',
                }
            }
            if(typeof this.value === 'object') {
                if(!('password' in this.value)) {
                    this.value.password = null;
                }
                if(!('name' in this.value)) {
                    this.value.name = null;
                }
                if(!('email' in this.value)) {
                    this.value.email = null;
                }
                if(!('address' in this.value)) {
                    this.value.address = null;
                }
                if(!('phone' in this.value)) {
                    this.value.phone = null;
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


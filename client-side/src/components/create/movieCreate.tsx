import {
	Create,
	ReferenceInput,
	required,
	SelectInput,
	SimpleForm,
	TextInput,
} from 'react-admin'

export const MovieCreate = () => (
	<Create>
		<SimpleForm>
			<TextInput source='title' validate={[required()]} label='Title' />
			<TextInput
				source='release_year'
				validate={[required()]}
				label='Release Year'
			/>
			<TextInput source='director' validate={[required()]} label='Director' />
			<TextInput source='rating' validate={[required()]} label='Rating' />
			<TextInput
				source='description'
				validate={[required()]}
				label='Description'
			/>
			<ReferenceInput source='category_id' reference='categories'>
				<SelectInput optionText='name' label={'Category'} />
			</ReferenceInput>
		</SimpleForm>
	</Create>
)

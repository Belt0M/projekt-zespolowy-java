import {
	Edit,
	ReferenceInput,
	required,
	SelectInput,
	SimpleForm,
	TextInput,
} from 'react-admin'

export const RentalEdit = () => {
	return (
		<Edit>
			<SimpleForm>
				<ReferenceInput source='user_id' reference='users'>
					<SelectInput optionText='username' label={'Username'} />
				</ReferenceInput>
				<ReferenceInput source='movie_id' reference='movies'>
					<SelectInput optionText='title' label={'Movies Title'} />
				</ReferenceInput>
				<TextInput
					source='rental_date'
					validate={[required()]}
					label='Rental Date'
				/>
				<TextInput
					source='return_date'
					validate={[required()]}
					label='Return Date'
				/>
				<TextInput source='status' validate={[required()]} label='Status' />
			</SimpleForm>
		</Edit>
	)
}

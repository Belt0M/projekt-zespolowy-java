import {
	Create,
	ReferenceInput,
	required,
	SelectInput,
	SimpleForm,
	TextInput,
	useCreate,
	useRedirect,
} from 'react-admin'

export const RentalCreate = () => {
	const [create] = useCreate()

	const onCreate = (data: unknown) => {
		create('rentals', {data: [data]})
	}

	const redirect = useRedirect()

	const onSuccess = () => {
		redirect(`/reviews`)
	}

	return (
		<Create mutationOptions={{onSuccess}}>
			<SimpleForm onSubmit={onCreate}>
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
		</Create>
	)
}
